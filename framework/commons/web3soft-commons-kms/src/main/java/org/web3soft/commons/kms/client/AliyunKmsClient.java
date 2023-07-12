package org.web3soft.commons.kms.client;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.kms.model.v20160120.CreateKeyRequest;
import com.aliyuncs.kms.model.v20160120.CreateKeyResponse;
import com.aliyuncs.kms.model.v20160120.DecryptRequest;
import com.aliyuncs.kms.model.v20160120.DecryptResponse;
import com.aliyuncs.kms.model.v20160120.DescribeKeyRequest;
import com.aliyuncs.kms.model.v20160120.DescribeKeyResponse;
import com.aliyuncs.kms.model.v20160120.EncryptRequest;
import com.aliyuncs.kms.model.v20160120.EncryptResponse;
import com.aliyuncs.kms.model.v20160120.GenerateDataKeyRequest;
import com.aliyuncs.kms.model.v20160120.GenerateDataKeyResponse;
import com.aliyuncs.kms.model.v20160120.ListKeysRequest;
import com.aliyuncs.kms.model.v20160120.ListKeysResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 阿里云kms包装(wrapper)实现
 * 注：在VPC环境中访问KMS服务,需要添加指向vpc内域名的自定义endpoint。并在后续访问KMS过程中，指定使用这个endpoint。
 * <p>
 * DefaultProfile.addEndpoint("cn-hangzhou-vpc", "cn-hangzhou-vpc", "Kms", "kms-vpc.cn-hangzhou.aliyuncs.com");
 * </p>
 *
 * @see <a href='https://help.aliyun.com/document_detail/43347.html">aliyun kms sdk demo</a>
 */
@Slf4j
public class AliyunKmsClient extends AbstractClient implements KmsClient {

    private String keyId;
    private DefaultAcsClient kmsClient;

    public AliyunKmsClient(final String region, final String accessKeyId, final String accessKeySecret, final String keyId) {
        this("", region, accessKeyId, accessKeySecret, keyId);
    }

    public AliyunKmsClient(final String vpcEndpoint, final String region, final String accessKeyId, final String accessKeySecret, final String keyId) {
        if (StringUtils.isNotBlank(vpcEndpoint)) {
            this.createVpcKmsClient(vpcEndpoint, region, accessKeyId, accessKeySecret, keyId);
        } else {
            this.createKmsClient(region, accessKeyId, accessKeySecret, keyId);
        }
    }

    private void createVpcKmsClient(final String vpcEndpoint, final String regionId, final String accessKeyId, final String accessKeySecret, final String keyId) {
        DefaultProfile.addEndpoint(regionId, "Kms", vpcEndpoint);
        this.createKmsClient(regionId, accessKeyId, accessKeySecret, keyId);
    }

    private void createKmsClient(final String regionId, final String accessKeyId, final String accessKeySecret, final String keyId) {
        final IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        this.keyId = keyId;
        this.kmsClient = new DefaultAcsClient(profile);
    }

    public String getKeyId() {
        return this.keyId;
    }

    public DefaultAcsClient getKmsClient() {
        return this.kmsClient;
    }

    public CreateKeyResponse createKey(final String keyDesc, final String keyUsage) throws ClientException {
        final CreateKeyRequest ckReq = new CreateKeyRequest();
        ckReq.setSysProtocol(ProtocolType.HTTPS);
        ckReq.setAcceptFormat(FormatType.JSON);
        ckReq.setSysMethod(MethodType.POST);
        ckReq.setDescription(keyDesc);
        ckReq.setKeyUsage(keyUsage);
        return this.kmsClient.getAcsResponse(ckReq);
    }

    public DescribeKeyResponse describeKey() throws ClientException {
        final DescribeKeyRequest decKeyReq = new DescribeKeyRequest();
        decKeyReq.setSysProtocol(ProtocolType.HTTPS);
        decKeyReq.setAcceptFormat(FormatType.JSON);
        decKeyReq.setSysMethod(MethodType.POST);
        decKeyReq.setKeyId(this.keyId);
        return this.kmsClient.getAcsResponse(decKeyReq);
    }

    public ListKeysResponse listKey(final int pageNumber, final int pageSize) throws ClientException {
        final ListKeysRequest listKeysReq = new ListKeysRequest();
        listKeysReq.setSysProtocol(ProtocolType.HTTPS);
        listKeysReq.setAcceptFormat(FormatType.JSON);
        listKeysReq.setSysMethod(MethodType.POST);
        listKeysReq.setPageNumber(pageNumber);
        listKeysReq.setPageSize(pageSize);
        return this.kmsClient.getAcsResponse(listKeysReq);
    }

    public GenerateDataKeyResponse generateDataKey(final String keyDesc, final int numOfBytes) throws ClientException {
        final GenerateDataKeyRequest genDKReq = new GenerateDataKeyRequest();
        genDKReq.setSysProtocol(ProtocolType.HTTPS);
        genDKReq.setAcceptFormat(FormatType.JSON);
        genDKReq.setSysMethod(MethodType.POST);

        //
        // Set parameter according to KMS openAPI document:
        // 1.KeyId
        // 2.KeyDescription
        // 3.NumberOfBytes
        //
        genDKReq.setKeySpec(keyDesc);
        genDKReq.setKeyId(this.keyId);
        genDKReq.setNumberOfBytes(numOfBytes);
        return this.kmsClient.getAcsResponse(genDKReq);
    }

    public EncryptResponse encrypt(final String plainText) throws ClientException {
        final EncryptRequest encReq = new EncryptRequest();
        encReq.setSysProtocol(ProtocolType.HTTPS);
        encReq.setAcceptFormat(FormatType.JSON);
        encReq.setSysMethod(MethodType.POST);
        encReq.setKeyId(this.keyId);
        encReq.setPlaintext(plainText);
        return this.kmsClient.getAcsResponse(encReq);
    }

    public DecryptResponse decrypt(final String cipherBlob) throws ClientException {
        final DecryptRequest decReq = new DecryptRequest();
        decReq.setSysProtocol(ProtocolType.HTTPS);
        decReq.setAcceptFormat(FormatType.JSON);
        decReq.setSysMethod(MethodType.POST);
        decReq.setCiphertextBlob(cipherBlob);
        return this.kmsClient.getAcsResponse(decReq);
    }

    @Override
    public ByteBuffer encryptAsByteBuffer(final String plainText) {
        return StandardCharsets.UTF_8.encode(this.encryptAsString(plainText));
    }

    @Override
    public ByteBuffer decryptAsByteBuffer(final String cipherBlob) {
        return StandardCharsets.UTF_8.encode(this.decryptAsString(cipherBlob));
    }

    @Override
    public ByteBuffer decryptAsByteBuffer(final ByteBuffer byteBuffer, final Map<String, String> encryptionContext) {
        final DecryptRequest decReq = new DecryptRequest();
        decReq.setSysProtocol(ProtocolType.HTTPS);
        decReq.setAcceptFormat(FormatType.JSON);
        decReq.setSysMethod(MethodType.POST);
        decReq.setCiphertextBlob(StandardCharsets.UTF_8.decode(byteBuffer).toString());
        decReq.setEncryptionContext("");
        try {
            return StandardCharsets.UTF_8.encode(this.kmsClient.getAcsResponse(decReq).getPlaintext());
        } catch (final Exception ex) {
            log.warn("aliyun decryptAsByteBuffer error", ex);
        }
        return null;
    }

    @Override
    public String encryptAsString(final String plainText) {
        try {
            return this.encrypt(plainText).getCiphertextBlob();
        } catch (final Exception ex) {
            log.warn("aliyun encryptAsString error", ex);
        }
        return null;
    }

    @Override
    public String decryptAsString(final String cipherBlob) {
        try {
            log.debug("cipherBlob={}", cipherBlob);
            return this.decrypt(cipherBlob).getPlaintext();
        } catch (final Exception ex) {
            log.warn("aliyun decryptAsString error", ex);
        }
        return null;
    }
}