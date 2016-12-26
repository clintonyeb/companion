package practise

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

class User{
    String name
}

interface UserService
{
    void save(User user)
}
@TestMixin(GrailsUnitTestMixin)
class Practise1Spec extends Specification {

    void "Stubbing Action 1"() {
        given: "A stubbed User Service"
        UserService service = Stub()
        service.save({User user -> user.name == 'Clinton'}) >> {
            throw new IllegalArgumentException()
        }

        when: ""
        service.save(new User(name: 'Clinton'))

        then:
        thrown(IllegalArgumentException)

        when: ""
        service.save(new User(name: 'Dan'))

        then: ""
        notThrown(IllegalArgumentException)
    }

    void "Mocking Action 1"(){
        given: "a mocked User Object"
        UserService service = Mock()
        User user1 = new  User(name: 'Clinton')
        User user2 = new User(name: 'Michael')

        when: ""
        service.save(user1)

        then: ""
        1 * service.save({User user -> user.name == 'Clinton'})

        when: ""
        service.save(user2)

        then:""
        0 * service.save({User user -> user.name == 'Clinton'})
    }


}