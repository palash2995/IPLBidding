package main;

public interface HomeInterface {
	public void playerSignUp(PlayerDetailsObject player);
	public void login(String userId,String password, String type);
	public void playerStats(String id);
	public void updatePlayer(PlayerDetailsObject player);
}
