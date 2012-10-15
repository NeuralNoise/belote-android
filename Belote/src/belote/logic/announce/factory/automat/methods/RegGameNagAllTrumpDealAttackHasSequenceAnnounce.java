/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package belote.logic.announce.factory.automat.methods;

import belote.bean.Game;
import belote.bean.Player;
import belote.bean.announce.Announce;
import belote.bean.pack.card.rank.Rank;
import belote.bean.pack.card.suit.Suit;
import belote.bean.pack.sequence.SequenceType;
import belote.logic.announce.factory.automat.methods.base.ConditionListMethod;
import belote.logic.announce.factory.automat.methods.conditions.DealAttackPlayer;
import belote.logic.announce.factory.automat.methods.conditions.HasSuit;
import belote.logic.announce.factory.automat.methods.conditions.base.MultipleAndCondition;
import belote.logic.announce.factory.automat.methods.suitDeterminators.SequenceSuit;

/**
 * RegGameNagAllTrumpWhenFirstAndHasSequenceAnnounce class. Announce factory method which creates nag all trump announce when has a sequence.
 * @author Dimitar Karamanov
 */
public final class RegGameNagAllTrumpDealAttackHasSequenceAnnounce extends ConditionListMethod {

    /**
     * Constructor.
     * @param game BelotGame instance class.
     */
    public RegGameNagAllTrumpDealAttackHasSequenceAnnounce(final Game game) {
        super(game);
        addAnnounceCondition(new MultipleAndCondition(new HasSuit(new SequenceSuit(SequenceType.Quarte, Rank.Jack)), new DealAttackPlayer(game)));
        addAnnounceCondition(new MultipleAndCondition(new HasSuit(new SequenceSuit(SequenceType.Quarte, Rank.Queen)), new DealAttackPlayer(game)));
        addAnnounceCondition(new MultipleAndCondition(new HasSuit(new SequenceSuit(SequenceType.Quarte, Rank.King)), new DealAttackPlayer(game)));
        addAnnounceCondition(new MultipleAndCondition(new HasSuit(new SequenceSuit(SequenceType.Quarte, Rank.Ace)), new DealAttackPlayer(game)));
        addAnnounceCondition(new MultipleAndCondition(new HasSuit(new SequenceSuit(SequenceType.Quint)), new DealAttackPlayer(game)));
    }

    /**
     * Returns the proper Announce when conditions match.
     * @param player who is on turn.
     * @return an Announce instance.
     */
    protected Announce createAnnounce(Player player) {
        final Suit suit = SequenceSuit.getSequenceSuit(player);
        return Announce.createSuitNormalAnnounce(player, suit);
    }
}