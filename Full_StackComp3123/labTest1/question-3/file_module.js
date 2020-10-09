const fs = require('fs');
const { chdir } = require('process');
const path = require('path')
const dir = './Logs';

function removeLogFiles() {
    //check if directory exists
    if(fs.existsSync(dir)){
        const files = fs.readdirSync(dir)
        //chk if files exist
        if (files.length > 0) {
            //loop through files deleting them
            files.forEach(function(fn) {
                if (fs.statSync(dir + "/" + fn).isDirectory()) {
                    
                    removeDir(dir + "/" + fn)
                } else {
                    console.log(`delete files...${fn}`)
                    fs.unlinkSync(dir + "/" + fn)
                }
            })
        }
        fs.rmdir(dir, e => {
            if (e) {throw e;}
            else {console.log("removed directory")}
        })
    } else {
        console.log("Logs doesn't exist")
    }
}

function createFiles() {
    let i = 0;
    if (!fs.existsSync(dir)){
        console.log('Creating Logs directory')
        fs.mkdirSync(dir, { recursive: true})
        process.chdir('./Logs');
        while (i < 10) {
            fs.writeFile(`log${i}.txt`, 'test', function (error) {
                if (error) throw error;
            })
            i++
        }
        
    } else {
        process.chdir('./Logs')
        while (i < 10) {
            fs.writeFile(`log${i}.txt`, 'test', function (error) {
                if (error) throw error;
            })
            i++
        }
    }

    dirPath = path.join(__dirname, "Logs")
    fs.readdir(dirPath, (err, files) => {
        if (err) { 
            console.log("can't find directory") 
        }
        else {
            files.forEach(function(file) {
                console.log(file)
            })
        }
    })
}

removeLogFiles();
createFiles();