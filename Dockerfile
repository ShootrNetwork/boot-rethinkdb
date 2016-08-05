FROM      fav24/java8
MAINTAINER Backend <backend@fav24.com>

ENV homedir /app/

RUN mkdir -p ${homedir} && \
	mkdir -p ${homedir}log && \
	touch ${homedir}logfile.log && \ 
	touch ${homedir}log/error.log && \ 
	ln -sf /dev/stdout ${homedir}logfile.log && \
	ln -sf /dev/stderr ${homedir}log/error.log

EXPOSE 8080

CMD java ${JVM_MIN_MEMROY:-'-Xms128m'} ${JVM_MAX_MEMROY:-'-Xmx512m'} -Duser.timezone=UTC -Dapp.home.dir=/app/ -Dfile.encoding=UTF-8 -jar /app/realtime-poc.jar

COPY realtime-poc.jar ${homedir}