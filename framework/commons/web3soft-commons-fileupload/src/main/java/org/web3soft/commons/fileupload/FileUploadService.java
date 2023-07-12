package org.web3soft.commons.fileupload;

import java.io.File;
import java.io.InputStream;

/**
 * @author web3soft-team
 */
public interface FileUploadService {

    /**
     * 上传文件
     *
     * @param file     当前上传文件对象
     * @param fileName 上传后的文件名称(可带路径）
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(File file, String fileName);

    /**
     * 上传文件
     *
     * @param inputStream 当前上传的文件流
     * @param fileName    上传后的文件名称(可带路径）
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(InputStream inputStream, String fileName);

    /**
     * 上传文件并存储到path目录下
     *
     * @param file     {@link File}
     * @param path     存储路径
     * @param fileName 上传后的文件名称(可带路径）
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(File file, String path, String fileName);

    /**
     * 上传文件并存储到path目录下
     *
     * @param inputStream {@link InputStream}
     * @param path        存储路径
     * @param fileName    上传后的文件名称(可带路径）
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(InputStream inputStream, String path, String fileName);

    /**
     * 上传文件
     *
     * @param file     当前上传文件对象
     * @param fileName 上传后的文件名称(可带路径）
     * @param acl      访问权限{@link CannedAclEnum}
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(File file, String fileName, CannedAclEnum acl);

    /**
     * 上传文件
     *
     * @param inputStream 当前上传的文件流
     * @param fileName    上传后的文件名称(可带路径）
     * @param acl         访问权限{@link CannedAclEnum}
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(InputStream inputStream, String fileName, CannedAclEnum acl);

    /**
     * 上传文件并存储到path目录下
     *
     * @param file     {@link File}
     * @param path     存储路径
     * @param fileName 上传后的文件名称(可带路径）
     * @param acl      访问权限{@link CannedAclEnum}
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(File file, String path, String fileName, CannedAclEnum acl);

    /**
     * 上传文件并存储到path目录下
     *
     * @param inputStream {@link InputStream}
     * @param path        存储路径
     * @param fileName    上传后的文件名称(可带路径）
     * @param acl         访问权限{@link CannedAclEnum}
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(InputStream inputStream, String path, String fileName, CannedAclEnum acl);

    /**
     * 上传文件
     *
     * @param file       当前上传的文件
     * @param fileName   上传后的文件名称(可带路径）
     * @param objectMeta 元数据
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(File file, String fileName, FileUploadMetadata objectMeta);

    /**
     * 上传文件
     *
     * @param inputStream 当前上传的文件流
     * @param fileName    上传后的文件名称(可带路径）
     * @param objectMeta  元数据
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(InputStream inputStream, String fileName, FileUploadMetadata objectMeta);

    /**
     * 上传文件
     *
     * @param file       当前上传的文件
     * @param path       存储路径
     * @param fileName   上传后的文件名称(可带路径）
     * @param objectMeta 元数据
     * @param acl        访问权限{@link CannedAclEnum}
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(File file, String path, String fileName, FileUploadMetadata objectMeta, CannedAclEnum acl);

    /**
     * 上传文件
     *
     * @param inputStream 当前上传的文件流
     * @param path        存储路径
     * @param fileName    上传后的文件名称(可带路径）
     * @param objectMeta  元数据
     * @param acl         访问权限{@link CannedAclEnum}
     * @return {@link FileUploadResponse}
     */
    FileUploadResponse uploadFile(InputStream inputStream, String path, String fileName, FileUploadMetadata objectMeta, CannedAclEnum acl);

    /**
     * 删除文件
     *
     * @param fileName 文件名称(可带路径）
     * @return true|false
     */
    boolean delete(String fileName);

    /**
     * 删除文件
     *
     * @param path     路径
     * @param fileName 文件名称(可带路径）
     * @return true|false
     */
    boolean delete(String path, String fileName);

    /**
     * 获取上传后的文件url地址
     *
     * @param fileName 文件名称(可带路径）
     * @return 上传文件的url
     */
    String getUrl(String fileName);

    /**
     * 获取上传后的文件url地址
     *
     * @param path     路径
     * @param fileName 文件名称(可带路径）
     * @return 上传文件的url
     */
    String getUrl(String path, String fileName);

    /**
     * 获取上传后的文件临时签名url地址
     *
     * @param fileName 文件名称(可带路径）
     * @return 带私有签名url地址
     */
    String getSignedUrl(String fileName);

    /**
     * 获取上传后的文件临时签名url地址
     *
     * @param path     路径
     * @param fileName 文件名称(可带路径）
     * @return 带私有签名url地址
     */
    String getSignedUrl(String path, String fileName);

    /**
     * 获取文件上传的bucket key
     *
     * @param fileName 上传的文件名称(可带路径）
     * @return bucket key
     */
    String getKey(String fileName);

    /**
     * 获取文件上传的bucket key
     *
     * @param path     路径
     * @param fileName 上传的文件名称(可带路径）
     * @return bucket key
     */
    String getKey(String path, String fileName);

    /**
     * 生成（yyyyMMdd)日期格式文件路径
     *
     * @return yyyyMMdd 路径
     */
    String getDatePath();

    /**
     * 生成日期格式文件目录
     *
     * @param pattern 日期时间模式(默认为yyyyMMdd)
     * @return pattern 路径
     */
    String getDatePath(String pattern);

    /**
     * 获取带日期时间格式(默认为yyyyMMdd)目录的文件名
     *
     * @param fileName 上传文件名(可带相对路径）
     * @return 带日期时间格式目录的文件名
     */
    String getDatePathFileName(String fileName);

    /**
     * 获取带日期时间格式目录的文件名
     *
     * @param fileName 上传文件名(可带相对路径）
     * @param pattern  日期时间模式(默认为yyyyMMdd)
     * @return 带日期时间格式目录的文件名
     */
    String getDatePathFileName(String fileName, String pattern);

    /**
     * 根据原文件名的扩展名基于UUID{@link java.util.UUID}新的文件名
     *
     * @param originalFileName 原文件名
     * @return UUID.{originalFileName.ext}
     */
    String getFileName(String originalFileName);

    /**
     * 根据原文件名的扩展名生成新的文件名称
     *
     * @param originalFileName 原文件名
     * @param newFileName      新文件名(不需要带扩展名）
     * @return newFileName.{originalFileName.ext}
     */
    String getFileName(String originalFileName, String newFileName);
}
