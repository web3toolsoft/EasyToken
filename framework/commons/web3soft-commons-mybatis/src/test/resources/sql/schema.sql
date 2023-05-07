DROP TABLE IF EXISTS TEST_USER;
CREATE TABLE TEST_USER
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    roles        VARCHAR(100) NOT NULL,
    account      VARCHAR(100) NOT NULL,
    password     VARCHAR(100) NOT NULL,
    salt         VARCHAR(100) NOT NULL,
    name         VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL,
    telephone    VARCHAR(100) NOT NULL,
    status       TINYINT      NOT NULL,
    comment      VARCHAR(100) NOT NULL,
    gmt_created  timestamp    NOT NULL,
    gmt_modified timestamp DEFAULT NULL
);
