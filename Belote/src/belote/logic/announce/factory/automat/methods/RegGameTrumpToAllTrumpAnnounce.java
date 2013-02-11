package belote.logic.announce.factory.automat.methods;

import belote.bean.Game;
import belote.bean.Player;
import belote.bean.announce.Announce;
import belote.logic.announce.factory.automat.methods.base.ConditionListMethod;

public class RegGameTrumpToAllTrumpAnnounce extends ConditionListMethod {

    /**
     * Constructor.
     * @param game BelotGame instance class.
     */
    public RegGameTrumpToAllTrumpAnnounce(final Game game) {
        super(game);
    }

    /**
     * Returns the proper Announce when conditions match.
     * @param player who is on turn.
     * @return an Announce instance.
     */
    protected Announce createAnnounce(final Player player) {
        Player partner = player.getPartner();
        
        Announce playerAnnounce = game.getAnnounceList().getContractAnnounce(player);
        Announce partnerAnnounce = game.getAnnounceList().getContractAnnounce(partner);
        
        if (playerAnnounce != null && partnerAnnounce != null && playerAnnounce.isTrumpAnnounce() && partnerAnnounce.isTrumpAnnounce()) {
            return Announce.createATNormalAnnounce(player);
        }

        return null;
    }
}