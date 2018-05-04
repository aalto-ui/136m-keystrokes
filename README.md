# 136 Million Keystrokes

This repository contains the source code for the typing speed test application,
which was used to collect the 136 million keystrokes that were analyzed for the
Observations on Typing from 136 Million Keystrokes paper published in CHI' 18.
More information on the project and exact references to the paper can be found
[Here](http://userinterfaces.aalto.fi/136Mkeystrokes/).

## Contents of the repository

The repository contains the code for running the entire typing speed test
application. The code for capturing keystrokes can be found under
`public/javascripts/typingtest.js`.

## Installation

The application is written in Scala with the Play!-framework. To install all
dependencies, run `sbt` in the root directory. You can build the application
with the `sbt build`-command. To be able to run the application, you will need
a MySQL-database. You can configure the database in `conf/application.conf`.

## License

The software is licensed under the MIT license. The license file can be found in
the root of this repository.
