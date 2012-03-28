package alocadorhorarios

import static org.junit.Assert.*
import org.junit.*

class DepartamentoTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testListagem() {
        def deptos = [
			new Departamento(cor: "#000000", nome:"DCE"),
			new Departamento(cor: "#FFFFFF", nome:"DE")]
		deptos*.save()
		
		assertEquals 2, Departamento.list().size()
    }
}
