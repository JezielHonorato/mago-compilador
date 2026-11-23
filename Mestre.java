public class Mestre extends Usuario {

	public Mestre(String login, String senha) {
		super(login, senha);
	}

	public Mestre(int id, String login, String senha) {
		super(id, login, senha);
	}

	@Override
	public Perfil getPerfil() {
		return Perfil.MESTRE;
	}

}
