# 学友笔记 

> 基于 Spring Cloud Alibaba 微服务架构的社交笔记平台，仿小红书实现

## 📖 项目简介

学友笔记是一个采用微服务架构开发的社交笔记分享平台，提供笔记发布、用户关系、搜索、文件存储等核心功能。项目采用主流的 Spring Cloud Alibaba 技术栈，适合学习微服务架构设计与实践。

## ✨ 核心功能

- 🔐 **用户认证**：手机号登录/注册、密码管理、Sa-Token 权限认证
- 👤 **用户管理**：用户信息维护、头像上传、个人资料编辑
- 📝 **笔记管理**：笔记发布、编辑、删除、置顶、可见性设置
- ❤️ **互动功能**：点赞、收藏、评论
- 👥 **社交关系**：关注/取消关注、粉丝管理
- 🔍 **搜索功能**：基于 Elasticsearch 的笔记和用户搜索
- 📁 **文件存储**：基于 MinIO 的图片/视频上传
- 📊 **计数服务**：点赞数、收藏数、浏览数统计
- 🔄 **数据同步**：基于 Canal 的 MySQL 数据实时同步

## 🛠 技术栈

### 后端框架
- **Java 17**
- **Spring Boot 3.0.2**
- **Spring Cloud Alibaba 2022.0.0.0**
- **Spring Cloud 2022.0.0**

### 微服务组件
- **Nacos**：服务注册与配置中心
- **Spring Cloud Gateway**：API 网关
- **OpenFeign**：服务间调用
- **Sa-Token**：权限认证框架

### 数据存储
- **MySQL 8.0**：关系型数据库
- **Redis**：缓存与会话存储
- **Elasticsearch 7.3**：全文搜索引擎
- **MinIO**：对象存储服务

### 中间件
- **RocketMQ**：消息队列
- **Canal**：MySQL binlog 数据同步
- **XXL-JOB**：分布式定时任务

### 工具库
- **MyBatis**：持久层框架
- **Druid**：数据库连接池
- **Lombok**：简化代码
- **Hutool**：Java 工具类库
- **Guava**：Google 核心库
- **Caffeine**：本地缓存

## 🏗 系统架构

### 微服务模块

```
xiaohashu
├── xiaohashu-gateway              # API 网关 (端口: 8000)
├── xiaohashu-auth                 # 认证服务 (登录/注册/登出)
├── xiaohashu-user                 # 用户服务 (用户信息管理)
├── xiaohashu-note                 # 笔记服务 (笔记 CRUD、点赞、收藏)
├── xiaohashu-user-relation        # 用户关系服务 (关注/粉丝)
├── xiaohashu-count                # 计数服务 (点赞数、收藏数统计)
├── xiaohashu-search               # 搜索服务 (ES 全文搜索)
├── xiaohashu-oss                  # 对象存储服务 (MinIO 文件上传)
├── xiaohashu-kv                   # KV 存储服务 (Redis 笔记内容)
├── xiaohashu-distributed-id-generator  # 分布式 ID 生成器 (Leaf)
├── xiaohashu-data-align           # 数据同步服务 (Canal)
└── xiaoha-framework               # 框架层
    ├── xiaoha-common              # 通用工具类、枚举、响应模型
    ├── xiaoha-spring-boot-starter-biz-context      # 业务上下文 (用户 ID 传递)
    ├── xiaoha-spring-boot-start-biz-operationlog   # 操作日志
    └── xiaoha-spring-boot-start-jackson            # Jackson 序列化配置
```

### 服务调用关系

- **Gateway** → 所有业务服务 (统一入口，路由转发)
- **Note** → User、KV、ID Generator、OSS (笔记发布依赖用户信息、内容存储、ID 生成)
- **Auth** → User (认证依赖用户服务)
- **Search** → 独立服务 (通过 Canal 同步数据到 ES)
- **Data Align** → MySQL、Elasticsearch (监听 binlog 同步数据)

## 🚀 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+
- Nacos 2.x
- Elasticsearch 7.3+
- MinIO
- RocketMQ 4.x

### 本地开发

1. **克隆项目**
```bash
git clone https://github.com/zizhuhuhu/xueyou.git
cd xiaohashu
```

2. **配置环境**
   - 启动 Nacos、MySQL、Redis、Elasticsearch、MinIO、RocketMQ
   - 导入数据库脚本 (如有)
   - 修改各服务的 `application-dev.yml` 配置文件

3. **编译项目**
```bash
mvn clean install
```

4. **启动服务**

按以下顺序启动服务：
```bash
# 1. 启动网关
cd xiaohashu-gateway
mvn spring-boot:run

# 2. 启动认证服务
cd xiaohashu-auth
mvn spring-boot:run

# 3. 启动用户服务
cd xiaohashu-user/xiaosashu-user-biz
mvn spring-boot:run

# 4. 启动其他业务服务...
```

5. **访问服务**
   - API 网关: http://localhost:8000
   - Nacos 控制台: http://localhost:8848/nacos

## 📦 模块说明

### 业务服务

| 服务名 | 说明 | 主要功能 |
|--------|------|----------|
| xiaohashu-gateway | API 网关 | 统一入口、路由转发、鉴权 |
| xiaohashu-auth | 认证服务 | 登录/注册、密码管理、验证码 |
| xiaohashu-user | 用户服务 | 用户信息、头像上传、资料编辑 |
| xiaohashu-note | 笔记服务 | 笔记发布/编辑/删除、点赞/收藏 |
| xiaohashu-user-relation | 关系服务 | 关注/取关、粉丝列表 |
| xiaohashu-count | 计数服务 | 点赞数、收藏数、浏览数统计 |
| xiaohashu-search | 搜索服务 | 笔记搜索、用户搜索 |
| xiaohashu-oss | 存储服务 | 图片/视频上传、MinIO 对接 |
| xiaohashu-kv | KV 服务 | 笔记内容存储 (Redis) |
| xiaohashu-distributed-id-generator | ID 生成器 | 分布式唯一 ID (Leaf 算法) |
| xiaohashu-data-align | 数据同步 | MySQL → Elasticsearch 同步 |

### 框架层

- **xiaoha-common**: 通用枚举、工具类、响应模型
- **xiaoha-spring-boot-starter-biz-context**: 业务上下文，用户 ID 在微服务间传递
- **xiaoha-spring-boot-start-biz-operationlog**: 操作日志切面
- **xiaoha-spring-boot-start-jackson**: Jackson 序列化配置

## 🔧 开发规范

### 模块结构

业务服务通常包含两个子模块：
- `*-api`: Feign 客户端接口和 DTO，供其他服务调用
- `*-biz`: 业务逻辑实现，包含 Spring Boot 启动类

### 包结构
```
com.quanxiaoha.xiaohashu.{service}.biz
├── config          # 配置类
├── controller      # REST 控制器
├── service         # 业务逻辑
├── domain
│   ├── dataobject  # 数据库实体 (DO)
│   └── mapper      # MyBatis Mapper
├── model
│   └── vo          # 视图对象 (VO)
├── rpc             # Feign 客户端调用
├── constant        # 常量
└── enums           # 枚举
```

## 📝 API 示例

### 用户登录
```bash
POST http://localhost:8000/auth/login
Content-Type: application/json

{
  "phone": "13800138000",
  "code": "123456"
}
```

### 发布笔记
```bash
POST http://localhost:8000/note/publish
Authorization: Bearer {token}
Content-Type: application/json

{
  "title": "笔记标题",
  "content": "笔记内容",
  "imgUris": ["https://example.com/img1.jpg"],
  "type": 1
}
```

## 📄 License

MIT License

## 👥 贡献

欢迎提交 Issue 和 Pull Request！
