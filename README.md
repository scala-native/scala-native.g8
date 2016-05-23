For the impatient
-----------------

1. Make sure you hava clang-3.7 or superior.
There's an [installation script for Debian Jessie] which does all the magic for you.

2. Make sure you install ``libgc-dev``
```
$ sudo apt-get install libgc-dev -y
```

3. Clone
```
$ mkdir -p $HOME/workspace
$ cd $HOME/workspace
$ git clone https://github.com/scala-native/scala-native.git
```
3. Building
```
$ cd $HOME/workspace/scala-native
$ sbt clean publishLocal
```
4. In case it fails, try ``sbt publishLocal`` again. This is common in case your .ivy2 repository is empty or never had scala-native artifacts published onto it.

5. Run the demo program
**NOTE: latest pull from master caused regression. IT WILL FAIL!**
```
$ sbt demoNative/run
```
6. Show results of the demo program
```
$ sudo apt-get install xdg-utils
$ xdg-open image0.ppm
```

[installation script for Debian Jessie]: https://gist.github.com/frgomes/daa33b2f7a6489196a95
