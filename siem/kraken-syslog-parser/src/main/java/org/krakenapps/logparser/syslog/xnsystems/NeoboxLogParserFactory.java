/*
 * Copyright 2012 Future Systems
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
package org.krakenapps.logparser.syslog.xnsystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Properties;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;
import org.krakenapps.log.api.LogParser;
import org.krakenapps.log.api.LogParserFactory;
import org.krakenapps.log.api.LoggerConfigOption;

@Component(name = "neobox-log-parser-factory")
@Provides
public class NeoboxLogParserFactory implements LogParserFactory {

	@Override
	public String getName() {
		return "neobox";
	}

	@Override
	public Collection<Locale> getDisplayNameLocales() {
		return Arrays.asList(Locale.ENGLISH);
	}

	@Override
	public String getDisplayName(Locale locale) {
		return "Neobox";
	}

	@Override
	public Collection<Locale> getDescriptionLocales() {
		return Arrays.asList(Locale.ENGLISH);
	}

	@Override
	public String getDescription(Locale locale) {
		return "XNsystems Neobox Log Parser";
	}

	@Override
	public Collection<LoggerConfigOption> getConfigOptions() {
		return new ArrayList<LoggerConfigOption>();
	}

	@Override
	public LogParser createParser(Properties config) {
		return new NeoboxLogParser();
	}
}
