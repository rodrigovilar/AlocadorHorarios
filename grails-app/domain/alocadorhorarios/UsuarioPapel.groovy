package alocadorhorarios

import org.apache.commons.lang.builder.HashCodeBuilder

class UsuarioPapel implements Serializable {

	Usuario secuser
	Papel secRole

	boolean equals(other) {
		if (!(other instanceof UsuarioPapel)) {
			return false
		}

		other.secuser?.id == secuser?.id &&
			other.secRole?.id == secRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (secuser) builder.append(secuser.id)
		if (secRole) builder.append(secRole.id)
		builder.toHashCode()
	}

	static UsuarioPapel get(long secuserId, long secRoleId) {
		find 'from SecuserSecRole where secuser.id=:secuserId and secRole.id=:secRoleId',
			[secuserId: secuserId, secRoleId: secRoleId]
	}

	static UsuarioPapel create(Usuario secuser, Papel secRole, boolean flush = false) {
		new UsuarioPapel(secuser: secuser, secRole: secRole).save(flush: flush, insert: true)
	}

	static boolean remove(Usuario secuser, Papel secRole, boolean flush = false) {
		UsuarioPapel instance = UsuarioPapel.findBySecuserAndSecRole(secuser, secRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Usuario secuser) {
		executeUpdate 'DELETE FROM SecuserSecRole WHERE secuser=:secuser', [secuser: secuser]
	}

	static void removeAll(Papel secRole) {
		executeUpdate 'DELETE FROM SecuserSecRole WHERE secRole=:secRole', [secRole: secRole]
	}

	static mapping = {
		id composite: ['secRole', 'secuser']
		version false
	}
}
