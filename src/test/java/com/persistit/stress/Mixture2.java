/**
 * Copyright © 2012 Akiban Technologies, Inc.  All rights reserved.
 * 
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * This program may also be available under different license terms.
 * For more information, see www.akiban.com or contact licensing@akiban.com.
 * 
 * Contributors:
 * Akiban Technologies, Inc.
 */

package com.persistit.stress;

import com.persistit.Persistit;
import com.persistit.Transaction.CommitPolicy;
import com.persistit.stress.unit.Stress1;
import com.persistit.stress.unit.Stress2;
import com.persistit.stress.unit.Stress5;
import com.persistit.stress.unit.Stress6;
import com.persistit.stress.unit.Stress7;

public class Mixture2 extends AbstractSuite {

    static String name() {
        return Mixture2.class.getSimpleName();
    }

    public static void main(String[] args) throws Exception {
        new Mixture2(args).runTest();
    }

    public Mixture2(final String[] args) {
        super(name(), args);
    }

    public void runTest() throws Exception {

        deleteFiles(substitute("$datapath$/persistit*"));

        add(new Stress1("repeat=1 count=1000000"));
        add(new Stress2("repeat=2 count=150000 seed=117"));
        add(new Stress5("repeat=5 count=100000"));
        add(new Stress6("repeat=1 count=50000 size=250"));
        add(new Stress7("repeat=1 count=60000 size=250 seed=121"));
        add(new Stress1("repeat=1 count=600000"));
        add(new Stress2("repeat=1 count=1000000 seed=217"));
        add(new Stress1("repeat=2 count=5000000"));
        add(new Stress2("repeat=3 count=150000 seed=118"));
        add(new Stress5("repeat=5 count=100000"));
        add(new Stress6("repeat=2 count=25000 size=250"));
        add(new Stress7("repeat=1 count=60000 size=250 seed=122"));
        add(new Stress1("repeat=1 count=600000"));
        add(new Stress2("repeat=1 count=1000000 seed=218"));
        add(new Stress1("repeat=1 count=10000000"));
        add(new Stress2("repeat=10 count=30000 seed=119"));
        add(new Stress5("repeat=50 count=10000"));
        add(new Stress6("repeat=3 count=5000 size=250"));
        add(new Stress7("repeat=10 count=6000 size=250 seed=123"));
        add(new Stress1("repeat=10 count=60000"));
        add(new Stress2("repeat=1 count=1000000 seed=219"));
        add(new Stress1("repeat=10 count=1000000"));
        add(new Stress2("repeat=10 count=30000 seed=120"));
        add(new Stress5("repeat=50 count=10000"));
        add(new Stress6("repeat=3 count=5000 size=250"));
        add(new Stress7("repeat=10 count=6000 size=250 seed=124"));
        add(new Stress1("repeat=10 count=60000"));
        add(new Stress2("repeat=3 count=100000 seed=220"));

        final Persistit persistit = makePersistit(16384, "50000", CommitPolicy.SOFT);

        try {
            execute(persistit);
        } finally {
            persistit.close();
        }
    }
}
