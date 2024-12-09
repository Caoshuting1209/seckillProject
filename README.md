### springboot的一般框架

Entity -> Mapper -> Service -> Controller



> 引入mabatis plus依赖，可以不用mapper.xml文件来编写SQL语句，直接在Mapper中注解即可
>
> 注解中涉及到的SQL语句命名要和数据库保持一致，而不采用驼峰事命名



### 终端程序启动方法

#### mysql启动： mysql.server start

#### redis启动：redis-server (ctrl + c) / （新开窗口）redis-cli (shut down)

#### J-meter（压力测试）：path -> sh jmeter

##### 	add thread group / add http request / add listener

#### Another-redis-destop-manager（redis可视化）：直接在application中启动



### 下一步待学习内容

[RBAC权限控制系统1](https://www.bilibili.com/video/BV1vD421u7zU/?spm_id_from=333.788.player.switch&vd_source=c601dba09fcd5ed41170f2ff79a9a181&p=7)

[RBAC权限控制系统2](https://www.bilibili.com/video/BV1N4vLePEu9?spm_id_from=333.788.videopod.episodes&vd_source=c601dba09fcd5ed41170f2ff79a9a181&p=8)



