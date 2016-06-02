import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class BootStrap {

    def init = { servletContext ->
//        String sqlFilePath = ApplicationHolder.application.parentContext.servletContext.getRealPath("/../scripts/data.sql")
//        String sqlString = new File(sqlFilePath).text
//        Sql sql = Sql.newInstance(CH.config.dataSource.url, CH.config.dataSource.username,
//                CH.config.dataSource.password, CH.config.dataSource.driverClassName)
//        sql.execute(sqlString)
    }
    def destroy = {
    }
}
