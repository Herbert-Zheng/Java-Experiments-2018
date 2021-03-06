# Java第二次上机

本次上机共有两个任务，分别都和命令行参数有关。

## Assignement 1: Class Substring

第一个任务目的是识别命令行中参数，其中第一个参数为字符串，第二个参数为字串开始的下标，第三个参数为所要截取字串的长度。

这个任务难度不大，只需要调用`String`类方法`substring`即可实现。

## Assignment 2: Calendar generating program

第二个任务中，要求建立类`cal`以打印任意给定月份的日历。年份和月份通过命令行参数给定，如果参数为空，则打印当前月份日历。

任务中，我使用了`java.util.Calendar`等包。

### `SetMonthAndYear`

该方法中有两个重载，分别是由参数和无参数。若有参数，则将日历设置为传入参数；若无，则设置为当前日期。

### `PrintMonthAndYear`

通过`java.util.SimpleDateFormat`打印出格式化的月份和年份。

### `PrintSunToSat`

简单地打印*Su*到*Sa*。

### `PrintDaysAccordingToMonthAndYear`

我认为这是该次任务的重点。因为打印日历需要不同的偏移，以符合真实情况中该月第一日所对应星期几。所以需要先求出偏移量，再根据偏移量进行打印。

按照示例中日期的对齐格式，也需要针对一位和两位的日期进行不同方式的打印。

## 想说的

本次实验依然有不满意的地方。如在**Calendar generating program**中，日期大于`10`的日期在结尾需要有空格，但是为了代码简洁，我并没有处理这个问题。要修正这个问题，尚需要一定时间的思考。