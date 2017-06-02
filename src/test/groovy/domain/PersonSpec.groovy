package domain

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import org.grails.orm.hibernate.HibernateDatastore
import grails.gorm.transactions.Rollback

class PersonSpec extends Specification {

    @Shared @AutoCleanup HibernateDatastore datastore = new HibernateDatastore(getClass().getPackage())

    @Rollback
    def "person can be safed with firstname and lastname"() {
        when:
        def p = new Person(firstName: 'Sergio', lastName: 'del Amo')
        p.save(flush: true)
        
        then:
        Person.count()
    }
}
