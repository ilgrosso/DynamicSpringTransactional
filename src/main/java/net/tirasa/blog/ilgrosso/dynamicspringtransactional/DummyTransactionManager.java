/*
 * Copyright (C) 2015 Tirasa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tirasa.blog.ilgrosso.dynamicspringtransactional;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class DummyTransactionManager extends AbstractPlatformTransactionManager {

    private static final long serialVersionUID = -8643904697488408121L;

    @Override
    protected Object doGetTransaction() throws TransactionException {
        return new Object();
    }

    @Override
    protected void doBegin(final Object transaction, final TransactionDefinition definition)
            throws TransactionException {
    }

    @Override
    protected void doCommit(final DefaultTransactionStatus status) throws TransactionException {
    }

    @Override
    protected void doRollback(final DefaultTransactionStatus status) throws TransactionException {
    }

}
