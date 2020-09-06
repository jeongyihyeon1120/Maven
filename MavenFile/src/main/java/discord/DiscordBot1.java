package discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class DiscordBot1 {
	
	public static JDA jda;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JDABuilder jb = new JDABuilder(AccountType.BOT);
        jb.setAutoReconnect(true);
        jb.setStatus(OnlineStatus.DO_NOT_DISTURB);
        jb.setToken("NzA3NDM1NjQ1NzE4NjI2MzU0.XrIx5Q.pjZEnJrui6TpmQcB1FR8-IO3RxM");
        jb.addEventListeners(new DiscordBot1TListener());
        try {
            jda = jb.build();
        } catch (LoginException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
