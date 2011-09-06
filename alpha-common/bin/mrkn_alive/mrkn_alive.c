#define LOG_TAG "MRKN Alive Daemon"
#define FREQUENCY 15
#include <utils/Log.h>
#include <unistd.h>
int main(int argc, char **argv) {
    LOGI("Started");
    int elapsed = 0;
    while(1) {
         sleep(FREQUENCY);
         elapsed += FREQUENCY;
         LOGI("I've been alive for about %d seconds", elapsed);
    }
}
