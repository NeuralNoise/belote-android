/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package belote.logic.play.strategy.automat.executors.trumps;

import belote.bean.Game;
import belote.bean.Player;
import belote.bean.announce.Announce;
import belote.bean.announce.AnnounceUnit;
import belote.bean.pack.card.Card;
import belote.bean.pack.card.suit.Suit;
import belote.logic.play.strategy.automat.base.executor.PlayCardExecutor;
import belote.logic.play.strategy.automat.methods.trumps.ColorObligatorySafeTrumpCard;
import belote.logic.play.strategy.automat.methods.trumps.ColorObligatorySomeTrumpCard;
import belote.logic.play.strategy.automat.methods.trumps.ColorObligatoryStandardTrumpCard;
import belote.logic.play.strategy.automat.methods.trumps.ColorObligatoryTrumpRoundLastCard;

/**
 * ColorNoTrumpAttackObligatoryFirstRuffCardExecutor executor. Implements the obligatory rules for defense player to play obligatory trump card in a color game.
 * @author Dimitar Karamanov
 */
public final class NoTrumpAttackObligatoryFirstRuffCardExecutor extends PlayCardExecutor {

    /**
     * Constructor.
     * @param game BelotGame instance.
     */
    public NoTrumpAttackObligatoryFirstRuffCardExecutor(final Game game) {
        super(game);
        // Register play card methods.
        register(new ColorObligatoryTrumpRoundLastCard(game));
        register(new ColorObligatorySafeTrumpCard(game));
        register(new ColorObligatoryStandardTrumpCard(game));
        register(new ColorObligatorySomeTrumpCard(game));
    }

    /**
     * Handler method providing the user facility to check custom condition for methods executions.
     * @param player for which is called the executor
     * @return true to process method execution false to not.
     */
    protected boolean fitPreCondition(final Player player) {
        boolean result = false;
        final Announce announce = game.getAnnounceList().getContractAnnounce();
        if (announce != null && announce.isColorAnnounce()) {
            final Suit trump = AnnounceUnit.transformFromAnnounceSuitToSuit(announce.getAnnounceSuit());
            final Card someTrumpCard = game.getTrickCards().findMaxSuitCard(trump);
            final Card bestAttackCard = game.getTrickCards().getHandAttackSuitCard();
            if (bestAttackCard != null) {
                final Player handPlayer = game.getPlayerByCard(bestAttackCard);
                result = someTrumpCard == null && handPlayer != null && !handPlayer.getTeam().equals(player.getTeam());
            }
        }
        return result;
    }
}