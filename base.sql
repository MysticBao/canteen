create table `stall`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `symbol` varchar(10) NOT NULL COMMENT '店铺英文简称',
    `name` varchar(50) DEFAULT NULL COMMENT '店铺显示名称',
    `desc` varchar(200) DEFAULT NULL,
    `create_time` datetime,
    `status` int(1) DEFAULT '0',
    UNIQUE KEY(`name`),
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='摊铺表';

create table `ums_admin`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    `icon` varchar(500) DEFAULT NULL,
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
    `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
    `create_time` date DEFAULT NULL,
    `last_login_time` date DEFAULT NULL,
    `status` int(1) DEFAULT '0',
    PRIMARY KEY(`id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

create table `ums_member`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    `icon` varchar(500) DEFAULT NULL,
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
    `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
    `create_time` date DEFAULT NULL,
    `last_login_time` date DEFAULT NULL,
    `status` int(1) DEFAULT '0',
    `level` int(1) DEFAULT '1' COMMENT '等级',
    UNIQUE KEY(`name`),
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

create table `ums_member_stall_relation`(
    `member_id` bigint(20) DEFAULT NULL,
    `stall_id` bigint(20) DEFAULT NULL  
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户摊位关联表';

create table `pms_product_stall_relation`(
    `product_id` bigint(20) DEFAULT NULL,
    `stall_id` bigint(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品摊位关联表';

create table `pms_product_category`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(64) NOT NULL,
    UNIQUE KEY(`name`),
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品类型表';

create table `pms_product_info`(
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `name` varchar(20) DEFAULT NULL,
     `icon` varchar(500) DEFAULT NULL,
     `status` int(1) DEFAULT '0',
     `price` decimal(10,2) DEFAULT NULL,
     `category_id` bigint(20) DEFAULT NULL,
     UNIQUE KEY(`name`),
     PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表';

