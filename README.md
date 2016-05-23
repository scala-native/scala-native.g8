## For the impatient

1. Make sure you hava clang-3.7 or superior.
[Installation script for Debian Jessie]

2. Make sure you install ``libgc-dev``.
```bash
    $ sudo apt-get install libgc-dev -y
```

3. Clone
```bash
    $ mkdir -p $HOME/workspace
    $ cd $HOME/workspace
    $ git clone https://github.com/scala-native/scala-native.git
```

3. Building
```bash
    $ cd $HOME/workspace/scala-native
    $ sbt clean publishLocal
```

4. In case it fails, try ``sbt publishLocal`` again. This is common in case your .ivy2 repository is empty or never had scala-native artifacts published onto it.

5. Run the demo program
**NOTE: latest pull from master caused regression. IT WILL FAIL!**
```bash
    $ sbt demoNative/run
```

6. Show results of the demo program
```bash
    $ sudo apt-get install xdg-utils
    $ xdg-open image0.ppm
```

[installation script for Debian Jessie]: https://gist.github.com/frgomes/daa33b2f7a6489196a95
