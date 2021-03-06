/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.stanbol.ontologymanager.ontonet.api.io;

import java.io.InputStream;

import org.apache.clerezza.rdf.core.TripleCollection;
import org.apache.clerezza.rdf.core.access.TcProvider;
import org.apache.clerezza.rdf.core.serializedform.Parser;
import org.apache.stanbol.ontologymanager.servicesapi.io.OntologyInputSource;

public class GraphContentInputSource extends
        org.apache.stanbol.ontologymanager.sources.clerezza.GraphContentInputSource implements
        OntologyInputSource<TripleCollection> {

    public GraphContentInputSource(InputStream content) {
        super(content);
    }

    public GraphContentInputSource(InputStream content, String formatIdentifier) {
        super(content, formatIdentifier);
    }

    public GraphContentInputSource(InputStream content, String formatIdentifier, TcProvider tcProvider) {
        super(content, formatIdentifier, tcProvider);
    }

    public GraphContentInputSource(InputStream content,
                                   String formatIdentifier,
                                   TcProvider tcProvider,
                                   Parser parser) {
        super(content, formatIdentifier, tcProvider, parser);
    }

    public GraphContentInputSource(InputStream content, TcProvider tcProvider) {
        super(content, tcProvider);
    }

}
