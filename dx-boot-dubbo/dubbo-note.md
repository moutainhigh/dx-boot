# dubbo注意事项目

## 关于dubbo的版本
    - alibaba
        - 使用springboot进行集成时候（dubbo-spring-boot-starter）使用的是alibaba的版本
        - 该项目的springboot项目有服务的监控，引入dubbo-spring-boot-actuator，进行相关配置
        - 目前Dubbo主要版本有两个：Dubbo 2.7和Dubbo 2.6：两个版本最大的差异，在于配置管理中心。Dubbo 
                2.6版本所有数据都存在注册中心上，Dubbo 2.7版本分成了注册中心，配置中心，和元数据中心。
        - Dubbo Admin配置说明：
            - 推荐使用，配置中心地址（还有直连等形式）
            - dubbo.registry.address
                - 不推荐使用，老版本的配置中心地址，比如：dubbo.registry.address="zookeeper://127.0.0.1:2181"
                - 如使用该配置，Dubbo Admin会将其作为注册中心和配置中心使用，元数据中心将无法使用，会影响服务测试等功能
        - dubbo monitor simple
         
       
        
    - apparche
       


