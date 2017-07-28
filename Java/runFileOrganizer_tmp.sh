#!/bin/bash

jarsPath=""
for jar in `find ~/.gradle/caches/modules-2/files-2.1/ -name *.jar`; do
    if [ -z "${jarsPath}" ]; then
        jarsPath="$jar"
    else
        jarsPath="$jarsPath:$jar"
    fi
done

#java -d64 -Xms2G -Xmx4G -Dfile.encoding=UTF-8 -cp /Users/pgajjar/Learning/learning/Java/build/classes/main:/Users/pgajjar/Learning/learning/Java/build/resources/main:$jarsPath com.datamanager.FileOrganizer /Users/pgajjar/data/ /Users/pgajjar/Downloads/ /Users/pgajjar/Documents/ /Users/pgajjar/MEGA/eBooks_temp/
java -d64 -Xms2G -Xmx4G -Dfile.encoding=UTF-8 -cp /Users/pgajjar/Learning/learning/Java/build/classes/main:/Users/pgajjar/Learning/learning/Java/build/resources/main:$jarsPath com.datamanager.FileOrganizer /tmp/test/
