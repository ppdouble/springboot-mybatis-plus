## Scheduled

**Method 1**

```java
@Component
@EnableScheduling
@EnableAsync
public class UpdateRecordMultiScheduledTask {

    @Async
    @Scheduled(cron = "0/10 * * * * ?")
    public void theFirstTask() {
        System.err.println("Multi task +++++ " + LocalDateTime.now());
    }
}
```

**Method 2**

```java
@Configuration
@EnableScheduling
public class UpdateRecordScheduledTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void theFirstTask() {
        System.err.println("Scheduled task: ----- " + LocalDateTime.now());
    }
}
```

## mybatis plus
 **UPDATE**
 
Using `UpdateWrapper`.

`LambdaUpdateWrapper` will get [WARNING: An illegal reflective access operation has occurred](https://github.com/baomidou/mybatis-plus/issues/3900).