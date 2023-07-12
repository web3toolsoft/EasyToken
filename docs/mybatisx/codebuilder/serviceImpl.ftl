package ${serviceImpl.packageName};

import ${tableClass.fullClassName};
import ${example.packageName}.${tableClass.shortClassName}Example;
import ${repository.packageName}.${tableClass.shortClassName}Repository;
import ${serviceInterface.packageName}.${tableClass.shortClassName}Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.springframework.stereotype.Service;

<#list tableClass.pkFields as field>
    <#assign pkFieldName = field.fieldName />
    <#assign pkColumnName = field.columnName />
    <#assign pkJdbcType = field.jdbcType />
    <#assign pkShortTypeName = field.shortTypeName />
</#list>
/**
* 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】的业务逻辑类
* @author ${author!}
* @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
@Service
public class ${serviceImpl.fileName}
        extends AbstractCrudService<${tableClass.shortClassName}Repository, ${tableClass.shortClassName}, ${tableClass.shortClassName}Example, ${pkShortTypeName}>
        implements ${tableClass.shortClassName}Service {

    public ${serviceImpl.fileName}(final ${tableClass.shortClassName}Repository ${tableClass.shortClassName?uncap_first}Repository) {
        super(${tableClass.shortClassName?uncap_first}Repository);
    }

    @Override
    protected ${tableClass.shortClassName}Example getPageExample(final String fieldName, final String keyword) {
        final ${tableClass.shortClassName}Example example = new ${tableClass.shortClassName}Example();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
