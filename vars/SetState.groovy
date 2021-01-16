import org.apache.commons.lang.StringUtils

def call(String filter_string, int occurance) {
    def logs = currentBuild.rawBuild.getLog(10000).join('\n')
    int count = StringUtils.countMatches(logs, filter_string);
    if(count > occurance) {
        currentBuild.result='UNSTABLE'
    }
}