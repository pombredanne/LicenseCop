License Cop
===========
A tool for adding license/copyright headers to your source files.   

Author: Dylan Just
License: Apache 2. See NOTICE and LICENSE files.

Usage
=====
  Command line:
    java -jar LicenseCop.jar folder

  Java:
    new LicenseCop().go(folder);

where 'folder' is the root folder of your project.
Your project requires a build/header.txt file containing your header text.
Requires java 6.

How it works
============
Assumes each source file starts with a block comment.
This comment is removed and replaced with a block comment containing the text in your header.txt file.

Template Fields
===============
You can insert ${year} into your header.txt, which will be replaced by the year in the output.

Caveats
=======
- Currently all source files are rewritten to disk, even if the header is already ok.
  Might be slow in larger projects.
- As it removes the block comment at the start of the file, you may lose non-license blocks (e.g. javadoc)'
  on the first run for a project
- Only supports .js and .java files
- Only block-style comments are supported.
- No line prefixes. i.e.
/*
license
*/
not:
/*
 * license
 */
- Runs in place, rather than copying to a temp file.
- Always uses \n for line endings - .git complains about this.