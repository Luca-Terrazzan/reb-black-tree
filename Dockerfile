FROM openjdk:15-alpine

COPY . /usr/src/red-black-tree
WORKDIR /usr/src/red-black-tree

RUN ["apk", "update"]
RUN ["apk", "upgrade"]
RUN ["apk", "add", "zsh"]
RUN ["apk", "add", "git"]
RUN ["apk", "add", "vim"]
RUN ["apk", "add", "maven"]

RUN wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh || true
