package discord;

import java.util.ArrayList;

import org.jsoup.nodes.Element;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordBot1TListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		User user = event.getAuthor();
		TextChannel tc = event.getTextChannel();
		Message msg = event.getMessage();
		if (user.isBot() && user.getName().equals("미니쿠다")) {
			tc.sendMessage(
					"검\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n열\n클린한 채팅방을 만듭시다.")
					.queue();
			return;
		} else if (user.getName().equals("P[EPSI]부계") || user.getName().equals("P[EPSI]")) {
			if(msg.getContentRaw().equals("")) {
				tc.sendMessage("씹덕 " + user.getAsMention()).queue();
			}
		}
		
	}
}