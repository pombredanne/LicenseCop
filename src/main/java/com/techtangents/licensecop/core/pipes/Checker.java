/*
Copyright 2010 Dylan Just

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.techtangents.licensecop.core.pipes;

import com.ephox.epipes.bool.predicates.Predicate;
import com.techtangents.licensecop.core.types.FileInfo;

public class Checker implements Predicate<FileInfo> {
    public boolean accept(FileInfo fileInfo) {
        
        // FIX: check if file is already ok - only accept files that need fixing
        return true;
    }
}