# Logger
Logger Library

A simple Logger Library for practicing SOLID principles.

## Tech

Java

## Images
Sample diagram 1
![Image](https://i.ibb.co/Dtzq76p/logger-diagram-1.jpg)
Sample diagram 2
![Image](https://i.ibb.co/gZqCzsh/logger-diagram-3.jpg)

## Example IO
Sample data:
```python
input:
2
ConsoleAppender SimpleLayout CRITICAL
FileAppender XmlLayout
INFO|3/26/2015 2:08:11 PM|Everything seems fine
WARNING|3/26/2015 2:22:13 PM|Warning: ping is too high - disconnect imminent
ERROR|3/26/2015 2:32:44 PM|Error parsing request
CRITICAL|3/26/2015 2:38:01 PM|No connection string found in App.config
FATAL|3/26/2015 2:39:19 PM|mscorlib.dll does not respond
END

output:
3/26/2015 2:38:01 PM - CRITICAL - No connection string found in App.config
3/26/2015 2:39:19 PM - FATAL - mscorlib.dll does not respond
Logger info
Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2
Appender type: FileAppender, Layout type: XmlLayout, Report level: INFO, Messages appended: 5, File size: 37526

```

## Contributing

Peter Stoilkov.

## License

[MIT](https://choosealicense.com/licenses/mit/)
