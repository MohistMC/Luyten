/*
 * Mohist - MohistMC
 * Copyright (C) 2018-2023.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.mohistmc.luyten;

import java.lang.instrument.Instrumentation;
import java.util.HashSet;
import java.util.Set;

public class JarLoader {

    private static Instrumentation instrumentation;

    public JarLoader() {
    }
    public static void agentmain(final String a, final Instrumentation inst) {
        JarLoader.instrumentation = inst;
    }
    public static void premain(String agentArgs, Instrumentation inst) {
        JarLoader.instrumentation = inst;
    }

    public static Set<Class<?>> getAllClassLoader() {
        Set<Class<?>> classLoaderSet = new HashSet<>();

        for (Class<?> clazz : instrumentation.getAllLoadedClasses()) {
            classLoaderSet.add(clazz);
        }
        return classLoaderSet;
    }
}