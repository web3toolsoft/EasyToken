package ${repository.packageName};

import ${tableClass.fullClassName};
import ${example.packageName}.${tableClass.shortClassName}Example;
import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;

<#list tableClass.pkFields as field>
    <#assign pkFieldName = field.fieldName />
    <#assign pkColumnName = field.columnName />
    <#assign pkJdbcType = field.jdbcType />
    <#assign pkShortTypeName = field.shortTypeName />
</#list>
/**
* 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】的数据库访问操作
* @author ${author!}
* @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
@Repository
public interface ${repository.fileName}
extends CrudRepository<${tableClass.shortClassName}, ${tableClass.shortClassName}Example, ${pkShortTypeName}>  {
}