package ${column.packageName};

/**
* 针对表【${tableClass.tableName}<#if tableClass.remark?has_content>(${tableClass.remark!})</#if>】列名类
* @author ${author!}
* @date ${.now?string('yyyy-MM-dd HH:mm:ss')}
*/
public class ${column.fileName} {

<#list tableClass.allFields as field>
    /**
    * ${field.remark!}
    */
    public static final String ${field.columnName?upper_case} = "${field.columnName}";

</#list>
}