/*
 * Copyright 2022-2023 Alexengrig Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.bhuyanp.gradle.figlet;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Set of fonts available
 *
 * @since 1.1
 */
public final class Fonts {

    private static SortedSet<String> NAMES;

    public static SortedSet<String> all() {
        if (NAMES == null) {
            SortedSet<String> result = new TreeSet<>(String::compareTo);
            result.addAll(LocalFontLoader.fontNames());
            result.addAll(LibraryFontLoader.fontNames());
            NAMES = result;
        }
        return NAMES;
    }

}
