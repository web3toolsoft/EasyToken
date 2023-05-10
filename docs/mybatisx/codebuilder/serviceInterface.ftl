package ${serviceInterface.packageName};

import ${tableClass.fullClassName};
import ${example.packageName}.${tableClass.shortClassName}Example;
import org.web3soft.commons.mybatis.service.CrudService;

<#list tableClass.pkFields as field>
    <#assign pkFieldName = field.fieldName />
    <#assign pkColumnName = field.columnName />
    <#assign pkJdbcType = field.jdbcType />
    <#assign pkShortTypeName = field.shortTypeName />
</#list>
/**
* 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】的业务逻辑接口
* @author ${author!}
* @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
public interface ${serviceInterface.fileName}
        extends CrudService<${tableClass.shortClassName}, ${tableClass.shortClassName}Example, ${pkShortTypeName}> {
}
