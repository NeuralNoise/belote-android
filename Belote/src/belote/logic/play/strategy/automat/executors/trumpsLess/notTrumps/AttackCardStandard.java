/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package belote.logic.play.strategy.automat.executors.trumpsLess.notTrumps;

import belote.bean.Game;
import belote.logic.play.strategy.automat.base.executor.PlayCardExecutor;
import belote.logic.play.strategy.automat.executors.PossiblePartnerSuitCard;
import belote.logic.play.strategy.automat.executors.trumpsLess.NeedlessCard;
import belote.logic.play.strategy.automat.methods.DominantSuitCard;
import belote.logic.play.strategy.automat.methods.MeterSuitCard;
import belote.logic.play.strategy.automat.methods.PartnerSuitAnnounceCard;
import belote.logic.play.strategy.automat.methods.TeamSuitPartnerCard;
import belote.logic.play.strategy.automat.methods.trumpsLess.ColorlessHandCard;
import belote.logic.play.strategy.automat.methods.trumpsLess.notTrump.NotTrumpMakePowerTenCard;

/**
 * Standard NotTrumpAttackCard executor. Used in NotTrumpPlayStategy getAttackCard().
 * @author Dimitar Karamanov
 */
class AttackCardStandard extends PlayCardExecutor {

    /**
     * Constructor.
     * @param game a BelotGame instance.
     */
    public AttackCardStandard(final Game game) {
        super(game);
        // Register play card methods.
        register(new MeterSuitCard(game));
        register(new TeamSuitPartnerCard(game));
        register(new DominantSuitCard(game));
        register(new PartnerSuitAnnounceCard(game));
        register(new NotTrumpMakePowerTenCard(game));
        register(new ColorlessHandCard(game));
        register(new PossiblePartnerSuitCard(game));
        register(new NeedlessCard(game));
    }
}