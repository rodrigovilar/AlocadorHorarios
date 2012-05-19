import alocadorhorarios.Usuario

class BootStrap {

    def init = { servletContext ->
		def Usuario = new Usuario (username: "Manuel", password: "1234")
    }
    def destroy = {
    }
}
