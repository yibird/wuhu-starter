rootProject.name = "wuhu-starter"
include("wuhu-starter-core")
include("wuhu-starter-captcha")
include("wuhu-starter-dependencies")
include("wuhu-starter-auth")
include("wuhu-starter-web")
include("wuhu-starter-auth:wuhu-starter-auth-satoken")
findProject(":wuhu-starter-auth:wuhu-starter-auth-satoken")?.name = "wuhu-starter-auth-satoken"
include("wuhu-starter-auth:wuhu-starter-auth-justauth")
findProject(":wuhu-starter-auth:wuhu-starter-auth-justauth")?.name = "wuhu-starter-auth-justauth"
include("wuhu-starter-extension")
include("wuhu-starter-data")

include("wuhu-starter-data:wuhu-starter-data-core")
findProject(":wuhu-starter-data:wuhu-starter-data-core")?.name = "wuhu-starter-data-core"
include("wuhu-starter-data:wuhu-starter-data-jimmer")
findProject(":wuhu-starter-data:wuhu-starter-data-jimmer")?.name = "wuhu-starter-data-jimmer"
include("wuhu-starter-data:wuhu-starter-data-mf")
findProject(":wuhu-starter-data:wuhu-starter-data-mf")?.name = "wuhu-starter-data-mf"
include("wuhu-starter-data:wuhu-starter-data-mp")
findProject(":wuhu-starter-data:wuhu-starter-data-mp")?.name = "wuhu-starter-data-mp"
include("wuhu-starter-cache")
include("wuhu-starter-log")
include("wuhu-starter-log:wuhu-starter-log-core")
findProject(":wuhu-starter-log:wuhu-starter-log-core")?.name = "wuhu-starter-log-core"
include("wuhu-starter-cache:wuhu-starter-cache-redisson")
findProject(":wuhu-starter-cache:wuhu-starter-cache-redisson")?.name = "wuhu-starter-cache-redisson"
include("wuhu-starter-cache:wuhu-starter-cache-jetcache")
findProject(":wuhu-starter-cache:wuhu-starter-cache-jetcache")?.name = "wuhu-starter-cache-jetcache"
include("wuhu-starter-cache:wuhu-starter-cache-l2cache")
findProject(":wuhu-starter-cache:wuhu-starter-cache-l2cache")?.name = "wuhu-starter-cache-l2cache"
include("wuhu-starter-api-doc")
include("wuhu-starter-trace")
include("wuhu-starter-ratelimiter")
include("wuhu-starter-idempotent")
include("wuhu-starter-security")
include("wuhu-starter-messaging")
include("wuhu-starter-messaging:wuhu-starter-messaging-ws")
findProject(":wuhu-starter-messaging:wuhu-starter-messaging-ws")?.name = "wuhu-starter-messaging-ws"
include("wuhu-starter-messaging:wuhu-starter-messaging-mail")
findProject(":wuhu-starter-messaging:wuhu-starter-messaging-mail")?.name = "wuhu-starter-messaging-mail"
include("wuhu-starter-json")
include("wuhu-starter-json:wuhu-starter-json-jackson")
findProject(":wuhu-starter-json:wuhu-starter-json-jackson")?.name = "wuhu-starter-json-jackson"
include("wuhu-starter-json:wuhu-starter-json-fastjson")
findProject(":wuhu-starter-json:wuhu-starter-json-fastjson")?.name = "wuhu-starter-json-fastjson"

include("wuhu-starter-extension:wuhu-starter-extension-crud")
findProject(":wuhu-starter-extension:wuhu-starter-extension-crud")?.name = "wuhu-starter-extension-crud"


include("wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-core")
findProject(":wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-core")?.name = "wuhu-starter-extension-crud-core"
include("wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-jimmer")
findProject(":wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-jimmer")?.name = "wuhu-starter-extension-crud-jimmer"
include("wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-mp")
findProject(":wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-mp")?.name = "wuhu-starter-extension-crud-mp"
include("wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-mf")
findProject(":wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-mf")?.name = "wuhu-starter-extension-crud-mf"
include("wuhu-starter-extension:wuhu-starter-extension-datapermission")
findProject(":wuhu-starter-extension:wuhu-starter-extension-datapermission")?.name = "wuhu-starter-extension-datapermission"
include("wuhu-starter-extension:wuhu-starter-extension-tenant")
findProject(":wuhu-starter-extension:wuhu-starter-extension-tenant")?.name = "wuhu-starter-extension-tenant"
include("wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-core")
findProject(":wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-core")?.name = "wuhu-starter-extension-tenant-core"
include("wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-mp")
findProject(":wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-mp")?.name = "wuhu-starter-extension-tenant-mp"
include("wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-jimmer")
findProject(":wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-jimmer")?.name = "wuhu-starter-extension-tenant-jimmer"
include("wuhu-starter-extension:wuhu-starter-extension-datapermission:wuhu-starter-extension-datapermission-core")
findProject(":wuhu-starter-extension:wuhu-starter-extension-datapermission:wuhu-starter-extension-datapermission-core")?.name = "wuhu-starter-extension-datapermission-core"
include("wuhu-starter-extension:wuhu-starter-extension-datapermission:wuhu-starter-extension-datapermission-mp")
findProject(":wuhu-starter-extension:wuhu-starter-extension-datapermission:wuhu-starter-extension-datapermission-mp")?.name = "wuhu-starter-extension-datapermission-mp"
include("wuhu-starter-extension:wuhu-starter-extension-datapermission:wuhu-starter-extension-datapermission-jimmer")
findProject(":wuhu-starter-extension:wuhu-starter-extension-datapermission:wuhu-starter-extension-datapermission-jimmer")?.name = "wuhu-starter-extension-datapermission-jimmer"
include("wuhu-starter-extension:wuhu-starter-extension-sort")
findProject(":wuhu-starter-extension:wuhu-starter-extension-sort")?.name = "wuhu-starter-extension-sort"
include("wuhu-starter-example")
include("wuhu-starter-security:wuhu-starter-security-crypto")
findProject(":wuhu-starter-security:wuhu-starter-security-crypto")?.name = "wuhu-starter-security-crypto"
