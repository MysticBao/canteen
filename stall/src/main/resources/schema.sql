create table `stall`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(10) NOT NULL,
    `label` varchar(50) DEFAULT NULL,
    `description` varchar(200) DEFAULT NULL,
    `create_time` datetime,
    `status` int(1) DEFAULT '0',
    UNIQUE KEY(`name`),
    PRIMARY KEY(`id`)
);

create table `product_info`(
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `name` varchar(20) DEFAULT NULL,
     `icon` varchar(500) DEFAULT NULL,
     `status` int(1) DEFAULT '0',
     `description` varchar(200) DEFAULT NULL,
     `price` decimal(10,2) DEFAULT NULL,
     `category_id` bigint(20) DEFAULT NULL,
     `brand_id` bigint(20) DEFAULT NULL,
     `create_time` datetime DEFAULT NULL,
     `last_update_time` datetime DEFAULT NULL,
     UNIQUE KEY(`name`),
     PRIMARY KEY(`id`)
);

create table `product_category`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `label` varchar(50) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `last_update_time` datetime DEFAULT NULL,
    UNIQUE KEY(`name`),
    PRIMARY KEY(`id`)
);
create table `product_brand`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `label` varchar(50) DEFAULT NULL,
    `description` varchar(500) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `last_update_time` datetime DEFAULT NULL,
    UNIQUE KEY(`name`),
    PRIMARY KEY(`id`)
);