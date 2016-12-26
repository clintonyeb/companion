import com.companion.Newsfeed
import com.companion.Tag
import com.companion.User

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                if (!Newsfeed.count()) {
                    createSampleData()
                }
            }
            test {
                if (!Newsfeed.count()) {
                    createSampleData()
                }
            }
        }
    }

    def createSampleData() {
        createNews()
        createUsers()
    }

    def createUsers() {
        def user1 = new User(nickName: 'clinton', password: 'clintonpassword').save(failOnError: true)
    }

    def createNews() {
        def news1 = new Newsfeed(webId: 'sport/live/2016/jul/30/us-pga-championship-2016-third-round-live',
                tag: Tag.findOrSaveWhere(sectionName: 'sport'), webPublicationDate: '2016-07-30T18:03:01Z',
                webTitle: 'US PGA Championship 2016: third round – live!',
                webUrl: 'https://www.theguardian.com/sport/live/2016/jul/30/us-pga-championship-2016-third-round-live',
                trailText: 'Follow all the action from day three at Baltusrol, with Scott Murray',
                thumbnail: 'https://media.guim.co.uk/f239e3bebb414077e9fce4e0cc2f09fe6edafc88/1162_778_3626_2175/500.jpg'
        ).save(failOnError: true)

        def news2 = new Newsfeed(webId: 'sport/2016/jul/30/rio-olympic-games-2016-mo-farah-jessica-ennis-hill-nicola-adams-usain-bolt-team-gb',
                tag: Tag.findOrSaveWhere(sectionName: 'sport'), webPublicationDate: '2016-07-30T18:00:13Z', webTitle: 'The essential Olympic Games planner for Rio 2016',
                webUrl: 'https://www.theguardian.com/sport/2016/jul/30/rio-olympic-games-2016-mo-farah-jessica-ennis-hill-nicola-adams-usain-bolt-team-gb',
                trailText: 'From Mo Farah and Jessica Ennis-Hill to Nicola Adams and Usain Bolt, here’s our guide on how to follow all of Team GB’s contenders and the big names across every event on every day of the Games – all times are in BST',
                thumbnail: 'https://media.guim.co.uk/857a50aaaac7a125fdfbe5223dc35801f7aecb78/0_296_4928_2957/500.jpg'
        ).save(failOnError: true)

        def news3 = new Newsfeed(webId: "football/live/2016/jul/30/barcelona-v-celtic-international-champions-cup-live",
                tag: Tag.findOrSaveWhere(sectionName: "football"), webPublicationDate: "2016-07-30T17:57:49Z",
                webTitle: "Barcelona v Celtic: International Champions Cup – live!",
                webUrl: "https://www.theguardian.com/football/live/2016/jul/30/barcelona-v-celtic-international-champions-cup-live",
                trailText: "<strong>Minute-by-minute report:</strong> Will Celtic put a taxing couple of weeks behind them to defeat Lionel Messi, Luis Suárez and co in Dublin? Join Nick Miller",
                thumbnail: "https://media.guim.co.uk/65e216c0a794a955347df7df0363bf90ff6c4ecc/0_311_5555_3332/500.jpg"
        ).save(failOnError: true)

        def news4 = new Newsfeed(webId: "commentisfree/2016/jul/30/donlad-trump-republicans-us-elections-dictatorship",
                tag: Tag.findOrSaveWhere(sectionName: "commentisfree"),
                webPublicationDate: "2016-07-30T17:45:12Z", webTitle: "Extremism thrives because of cowardly collaborators | Nick Cohen",
                webUrl: "https://www.theguardian.com/commentisfree/2016/jul/30/donlad-trump-republicans-us-elections-dictatorship",
                trailText: "Donald Trump is being allowed such free rein because Republicans are reluctant to face him down",
                thumbnail: "https://media.guim.co.uk/bef332efeae469e9827738d6e8b6d489f533bac7/0_182_5472_3283/500.jpg"
        ).save(failOnError: true)

        def news5 = new Newsfeed(webId: "politics/2016/jul/30/corbyn-accused-of-bottling-hustings-with-smith-after-rejecting-debate",
                tag: Tag.findOrSaveWhere(sectionName: "politics"),
                webPublicationDate: "2016-07-30T17:39:07Z", webTitle: "Corbyn accused of 'bottling' hustings with Smith after rejecting debate",
                webUrl: "https://www.theguardian.com/politics/2016/jul/30/corbyn-accused-of-bottling-hustings-with-smith-after-rejecting-debate",
                trailText: "Former shadow attorney general criticises Labour leader after his team told Channel 4 News he will not attend their debate with leadership challenger",
                thumbnail: "https://media.guim.co.uk/9438bf719215271dd47cddbebdbfaa24a3183d23/0_117_4815_2890/500.jpg"
        ).save(failOnError: true)

        def news6 = new Newsfeed(webId: "us-news/2016/jul/30/donald-trump-muslim-father-khizr-khan-democratic-convention-speech",
                tag: Tag.findOrSaveWhere(sectionName: "us-news"), webPublicationDate: "2016-07-30T17:17:02Z",
                webTitle: "Donald Trump attacks Muslim father's Democratic convention speech",
                webUrl: "https://www.theguardian.com/us-news/2016/jul/30/donald-trump-muslim-father-khizr-khan-democratic-convention-speech",
                trailText: "Trump suggests Clinton campaign wrote speech given by Khizr Khan on son killed in US army and claims father’s wife ‘probably … wasn’t allowed to have anything to say’",
                thumbnail: "https://media.guim.co.uk/397233539b9ca06306ee796270a08c540a32cb49/0_221_4231_2538/500.jpg"
        ).save(failOnError: true)

        def news7 = new Newsfeed(webId: "us-news/2016/jul/30/hillary-clinton-donald-trump-post-convention-poll",
                tag: Tag.findOrSaveWhere(sectionName: "us-news"), webPublicationDate: "2016-07-30T16:54:20Z",
                webTitle: "Hillary Clinton sees post-convention boost over Trump, but will it last?",
                webUrl: "https://www.theguardian.com/us-news/2016/jul/30/hillary-clinton-donald-trump-post-convention-poll",
                trailText: "Democratic presidential nominee gets 46% support compared with Trump’s 31% among likely voters, according to nationwide survey",
                thumbnail: "https://media.guim.co.uk/e0c0fc34fad28f9f98e5f2c2105de78e5b41668a/62_103_2417_1450/500.jpg"
        ).save(failOnError: true)

        def news8 = new Newsfeed(webId: "sport/2016/jul/30/warrington-wakefield-challenge-cup-semi-final-match-report",
                tag: Tag.findOrSaveWhere(sectionName: "sport"), webPublicationDate: "2016-07-30T16:47:43Z",
                webTitle: "Warrington bypass Wakefield on way to Wembley and Challenge Cup final",
                webUrl: "https://www.theguardian.com/sport/2016/jul/30/warrington-wakefield-challenge-cup-semi-final-match-report",
                trailText: "Warrington Wolves overwhelmed Wakefield 56-12 in the Challenge Cup semi-final and will play Hull FC on 27 August at Wembley",
                thumbnail: "https://media.guim.co.uk/fc22e0f319f94e456849725781fb4c9a04f0b9e9/22_54_3344_2006/500.jpg"
        ).save(failOnError: true)

        def news9 = new Newsfeed(webId: "sport/2016/jul/30/horse-racing-tips-sunday",
                tag: Tag.findOrSaveWhere(sectionName: "sport"), webPublicationDate: "2016-07-30T16:25:11Z",
                webTitle: "Horse racing tips: Sunday 31 July",
                webUrl: "https://www.theguardian.com/sport/2016/jul/30/horse-racing-tips-sunday",
                trailText: "Gabrial The Tiger (3.50 Chester) is the nap; Ice Age (3.40 Chepstow) is next best",
                thumbnail: "https://media.guim.co.uk/891dac2f3e91a307db540f58e351ad6066cbae89/0_336_2208_1324/500.jpg"
        ).save(failOnError: true)

        def news10 = new Newsfeed(webId: "sport/2016/jul/30/ferrari-james-allison-formula-one",
                tag: Tag.findOrSaveWhere(sectionName: "sport"), webPublicationDate: "2016-07-30T15:48:30Z",
                webTitle: "Wobbling Ferrari must refocus on priorities after James Allison’s departure",
                webUrl: "https://www.theguardian.com/sport/2016/jul/30/ferrari-james-allison-formula-one",
                trailText: "Formula One’s traditional giants have flattered to deceive for too long and must avoid reverting to a short-term view if they are to succeed again",
                thumbnail: "https://media.guim.co.uk/c589b2c91ddcab348e9d5cf6413adf20bbf92c5c/0_74_2584_1551/500.jpg"
        ).save(failOnError: true)
    }

    def destroy = {
    }
}
