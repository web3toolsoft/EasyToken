-- ----------------------------
-- Records of test_user
-- ----------------------------
BEGIN;
INSERT INTO `test_user` (`id`, `roles`, `account`, `password`, `salt`, `name`, `email`, `telephone`, `status`, `comment`, `gmt_created`,
                         `gmt_modified`)
VALUES (1, '4', 'admin', '436a5530ff7436c546dc2047d24fff46', 'c1d69267a3fd2e207408b68f8662cf27', '管理员', '14068728@qq.com', '123456789', 1, 'sa',
        '2023-01-05 17:38:50', '2023-01-05 17:38:50');
INSERT INTO `test_user` (`id`, `roles`, `account`, `password`, `salt`, `name`, `email`, `telephone`, `status`, `comment`, `gmt_created`,
                         `gmt_modified`)
VALUES (2, '23', 'test', 'c2b57a2b72ec4f289c8daa68aa7fb3a6', '283facc4dc9896ddb303a736be9530ea', 'tester', 'tester@qq.com', '12343423423', 1, '1',
        '2023-12-20 18:06:59', '2023-08-14 10:04:00');
COMMIT;
