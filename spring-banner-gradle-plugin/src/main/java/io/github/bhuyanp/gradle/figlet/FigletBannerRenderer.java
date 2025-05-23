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

import com.github.dtmo.jfiglet.FigFont;
import com.github.dtmo.jfiglet.FigletRenderer;

import java.util.Objects;
import java.util.Set;

public final class FigletBannerRenderer {

    public static final FigletBannerRenderer SINGLETON = new FigletBannerRenderer();

    private final Set<FontLoader> fontLoaders;

    private FigletBannerRenderer() {
        fontLoaders = Set.of(
                new LibraryFontLoader(),
                new LocalFontLoader()
        );
    }

    public String render(String font, String text) {
        Objects.requireNonNull(font, "font");
        Objects.requireNonNull(text, "text");
        for (FontLoader fontLoader : fontLoaders) {
            if (fontLoader.hasFont(font)) {
                FigFont figFont = fontLoader.loadFont(font);
                final FigletRenderer renderer = new FigletRenderer(figFont);
                return renderer.renderText(text);
            }
        }
        throw new IllegalArgumentException("Unknown font: " + font);
    }

}
