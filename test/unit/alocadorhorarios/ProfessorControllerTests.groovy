package alocadorhorarios



import org.junit.*
import grails.test.mixin.*

@TestFor(ProfessorController)
@Mock(Professor)
class ProfessorControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/professor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.professorInstanceList.size() == 0
        assert model.professorInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.professorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.professorInstance != null
        assert view == '/professor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/professor/show/1'
        assert controller.flash.message != null
        assert Professor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/professor/list'


        populateValidParams(params)
        def professor = new Professor(params)

        assert professor.save() != null

        params.id = professor.id

        def model = controller.show()

        assert model.professorInstance == professor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/professor/list'


        populateValidParams(params)
        def professor = new Professor(params)

        assert professor.save() != null

        params.id = professor.id

        def model = controller.edit()

        assert model.professorInstance == professor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/professor/list'

        response.reset()


        populateValidParams(params)
        def professor = new Professor(params)

        assert professor.save() != null

        // test invalid parameters in update
        params.id = professor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/professor/edit"
        assert model.professorInstance != null

        professor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/professor/show/$professor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        professor.clearErrors()

        populateValidParams(params)
        params.id = professor.id
        params.version = -1
        controller.update()

        assert view == "/professor/edit"
        assert model.professorInstance != null
        assert model.professorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/professor/list'

        response.reset()

        populateValidParams(params)
        def professor = new Professor(params)

        assert professor.save() != null
        assert Professor.count() == 1

        params.id = professor.id

        controller.delete()

        assert Professor.count() == 0
        assert Professor.get(professor.id) == null
        assert response.redirectedUrl == '/professor/list'
    }
}
