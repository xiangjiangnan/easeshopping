# easeshopping #
这是一个简易版本的商城购物系统，商城名字取自netease中ease和shopping的结合，意在轻松购物

## 技术框架 ##
1.主要采用了Spring Boot + MyBatis + FreeMarker + MySQL技术框架

2.业务逻辑主要分为四部分：首页展示、用户登录、买家业务和卖家业务

3.采用Spring Security实现对用户的认证

4.工程采用Gradle来管理，数据库实体和mapper的生成采用MyBatis Generator

5.目前主要涉及到三张数据库表，分别是user，commodity，account，分别用于用户·商品和订单，购物车有一张表，目前尚未使用，具体表字段在test的resources目录下




