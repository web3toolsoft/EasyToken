package ${domain.packageName};

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】的实体类
* @author ${author!}
* @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ${domain.fileName} {

<#list tableClass.allFields as field>
    /**
    * ${field.remark!}
    */
    private ${field.shortTypeName} ${field.fieldName?uncap_first};

</#list>
}