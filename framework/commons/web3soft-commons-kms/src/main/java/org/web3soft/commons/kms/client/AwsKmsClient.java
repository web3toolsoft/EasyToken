package org.web3soft.commons.kms.client;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.CreateKeyRequest;
import com.amazonaws.services.kms.model.CreateKeyResult;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import com.amazonaws.services.kms.model.DescribeKeyRequest;
import com.amazonaws.services.kms.model.DescribeKeyResult;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazonaws.services.kms.model.ListKeysRequest;
import com.amazonaws.services.kms.model.ListKeysResult;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Aws kms client 包装(wrapper)实现
 *
 * @see <a href="https://docs.aws.amazon.com/zh_cn/kms/latest/developerguide/overview.html">kms</a>
 * @see <a href="https://docs.aws.amazon.com/zh_cn/kms/latest/developerguide/programming-keys.html">ksm</a>
 */
@Slf4j
public class AwsKmsClient extends AbstractClient implements KmsClient {

    private final String keyId;
    private final AWSKMS kmsClient;

    /**
     * @param endpoint
     * @param region
     * @param accessKeyId
     * @param accessKeySecret
     * @param keyId           arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab
     */
    public AwsKmsClient(final String endpoint, final String region, final String accessKeyId, final String accessKeySecret, final String keyId) {
        final BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, accessKeySecret);
        this.kmsClient = AWSKMSClient.builder()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
        this.keyId = keyId;
    }

    /**
     * @return KeyId
     */
    public String getKeyId() {
        return this.keyId;
    }

    /**
     * @return Client
     */
    public AWSKMS getKmsClient() {
        return this.kmsClient;
    }

    /**
     * 创建客户主密钥
     *
     * @param desc Key for protecting critical data
     * @return {@link CreateKeyRequest}
     */
    public CreateKeyResult createKey(final String desc) {
        final CreateKeyRequest req = new CreateKeyRequest().withDescription(desc);
        return this.kmsClient.createKey(req);
    }

    /**
     * 生成数据密钥
     * <code>
     * final ByteBuffer plaintextKey = dataKeyResult.getPlaintext();
     * final ByteBuffer encryptedKey = dataKeyResult.getCiphertextBlob();
     * </code>
     *
     * @return {@link GenerateDataKeyResult}
     */
    public GenerateDataKeyResult generateDataKey() {
        final GenerateDataKeyRequest dataKeyRequest = new GenerateDataKeyRequest();
        dataKeyRequest.setKeyId(this.keyId);
        dataKeyRequest.setKeySpec("AES_128");
        return this.kmsClient.generateDataKey(dataKeyRequest);
    }

    /**
     * 查看自定义主密钥
     *
     * @return {@link DescribeKeyRequest}
     */
    public DescribeKeyResult describeKey() {
        final DescribeKeyRequest req = new DescribeKeyRequest().withKeyId(this.keyId);
        return this.kmsClient.describeKey(req);
    }

    /**
     * 获取客户主密钥的密钥 ID 和密钥 ARN
     *
     * @param marker
     * @param limit
     * @return {@link ListKeysResult}
     */
    public ListKeysResult listKeys(final String marker, final int limit) {
        final ListKeysRequest req = new ListKeysRequest()
                .withMarker(marker)
                .withLimit(limit);
        return this.kmsClient.listKeys(req);
    }

    /**
     * 加密数据密钥
     *
     * @param plainText 明文字符串(UTF-8)
     * @return {@link EncryptResult}
     */
    public EncryptResult encrypt(final String plainText) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(plainText.getBytes(StandardCharsets.UTF_8));
        final EncryptRequest req = new EncryptRequest()
                .withKeyId(this.keyId)
                .withPlaintext(byteBuffer);
        return this.kmsClient.encrypt(req);
    }

    /**
     * 解密数据密钥
     *
     * @param cipherBlob 密文(UTF-8)
     * @return {@link DecryptResult}
     */
    public DecryptResult decrypt(final String cipherBlob) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(cipherBlob.getBytes(StandardCharsets.UTF_8));
        final DecryptRequest req = new DecryptRequest().withCiphertextBlob(byteBuffer);
        return this.kmsClient.decrypt(req);
    }

    @Override
    public ByteBuffer decryptAsByteBuffer(final ByteBuffer byteBuffer, final Map<String, String> encryptionContext) {
        final DecryptRequest req = new DecryptRequest()
                .withCiphertextBlob(byteBuffer)
                .withEncryptionContext(encryptionContext);
        return this.kmsClient.decrypt(req).getPlaintext();
    }

    @Override
    public ByteBuffer encryptAsByteBuffer(final String plainText) {
        return this.encrypt(plainText).getCiphertextBlob();
    }

    @Override
    public ByteBuffer decryptAsByteBuffer(final String cipherBlob) {
        return this.decrypt(cipherBlob).getPlaintext();
    }

    @Override
    public String encryptAsString(final String plainText) {
        try {
            final ByteBuffer byteBuffer = this.encrypt(plainText).getCiphertextBlob();
            return StandardCharsets.UTF_8.decode(byteBuffer).toString();
        } catch (final Exception ex) {
            log.warn("aws encryptAsString error", ex);
        }
        return null;
    }

    @Override
    public String decryptAsString(final String cipherBlob) {
        try {
            final ByteBuffer byteBuffer = this.decrypt(cipherBlob).getPlaintext();
            return StandardCharsets.UTF_8.decode(byteBuffer).toString();
        } catch (final Exception ex) {
            log.warn("aws decryptAsString error", ex);
        }
        return null;
    }
}